package tn.isg.soa.gestion_elections.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import tn.isg.soa.gestion_elections.Models.Avis;
import tn.isg.soa.gestion_elections.Models.AvisID;

@RepositoryRestResource
public interface AvisRepository extends JpaRepository<Avis, AvisID> {
}
