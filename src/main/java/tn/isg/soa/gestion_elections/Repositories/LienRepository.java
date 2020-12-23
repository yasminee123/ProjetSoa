package tn.isg.soa.gestion_elections.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import tn.isg.soa.gestion_elections.Models.Lien;

@RepositoryRestResource
public interface LienRepository extends JpaRepository<Lien,Long> {
}
