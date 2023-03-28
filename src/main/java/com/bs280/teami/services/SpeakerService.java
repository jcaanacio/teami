package com.bs280.teami.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs280.teami.models.Speaker;
import com.bs280.teami.repositories.SpeakerRepository;

@Service
public class SpeakerService {

    @Autowired
    private SpeakerRepository speakerRepository;

    public List<Speaker> list() {
        return speakerRepository.findAll();
    }

    public Speaker create(Speaker speaker) {
        return speakerRepository.saveAndFlush(speaker);
    }


    public Speaker get(Long id) {
        return speakerRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        /**
         * TODO: Cascade delete
         */
        speakerRepository.deleteById(id);
    }


    public Speaker update(Long id, Speaker speaker) {
        /**
         * TODO: Add validation that all attributes are passed in, otherwise return 400
         */
        Speaker existingSpeaker = speakerRepository.getReferenceById(id);
        BeanUtils.copyProperties(speaker,existingSpeaker,"speaker_id");
        return speakerRepository.saveAndFlush(existingSpeaker);
    }
}
