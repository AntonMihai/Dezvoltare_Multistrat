package org.scrum.domain.services;

import org.springframework.stereotype.Service;

@Service
public interface IAngajatDomainService {
    public void setAngajatEntityRepository(IAngajatEntityRepository repository);
}
