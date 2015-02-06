package be.vdab.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import be.vdab.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
