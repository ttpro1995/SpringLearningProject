package me.thaithien.springtutorial.SpringLearningProject.restservice.event;

import me.thaithien.springtutorial.SpringLearningProject.restservice.service.SequenceGeneratorService;
import me.thaithien.springtutorial.SpringLearningProject.restservice.model.Kitten;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;


@Component
public class KittenModelListener extends AbstractMongoEventListener<Kitten> {

    private SequenceGeneratorService sequenceGenerator;

    @Autowired
    public KittenModelListener(SequenceGeneratorService sequenceGenerator) {
        this.sequenceGenerator = sequenceGenerator;
    }

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Kitten> event) {
        if (event.getSource().getId() == null) {
            event.getSource().setId(sequenceGenerator.generateSequence(Kitten.SEQUENCE_NAME));
        }
    }


}
