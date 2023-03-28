package com.bs280.teami.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs280.teami.repositories.SessionRepository;
import com.bs280.teami.models.Session;

@Service
public class SessionService {
    @Autowired
    private SessionRepository sessionRepository;

    public List<Session> list() {
        return sessionRepository.findAll();
    }

    public Session create(Session session) {
        return sessionRepository.saveAndFlush(session);
    }

    public Session get(Long id) {
        return sessionRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        /**
         * TODO: Cascade delete
         */
        sessionRepository.deleteById(id);
    }

    public Session update(Long id,Session session) {
        /**
         * TODO: Add validation that all attributes are passed in, otherwise return 400
         *
         * **/
        Session existingSession = sessionRepository.getReferenceById(id);
        BeanUtils.copyProperties(session, existingSession, "session_id");
        return sessionRepository.saveAndFlush(existingSession);
    }

    
}
