package tn.isg.soa.gestion_elections.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import tn.isg.soa.gestion_elections.Models.Parti;

@RepositoryRestResource
public interface PartiRepository extends JpaRepository<Parti,Long> {
}
