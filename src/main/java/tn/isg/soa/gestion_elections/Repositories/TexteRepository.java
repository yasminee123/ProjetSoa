package tn.isg.soa.gestion_elections.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import tn.isg.soa.gestion_elections.Models.Texte;

@RepositoryRestResource
public interface TexteRepository extends JpaRepository<Texte,Long> {
}
