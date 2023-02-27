package br.com.petz.clientepet.pet.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import br.com.petz.clientepet.cliente.handler.APIException;
import br.com.petz.clientepet.pet.Pet;
import br.com.petz.clientepet.pet.application.service.PetRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class PetInfraRepository implements PetRepository {
	private final PetSpringDataJPARepository petSpringDataJPARepository;
	
	@Override
	public Pet salvaPet(Pet pet) {
		petSpringDataJPARepository.save(pet);
		log.info("[finish] PetInfraRepository - salvaPet");
		return pet;
	}

	@Override
	public List<Pet> buscaPetsDoClienteComID(UUID idCliente) {
		log.info("[start] PetInfraRepository - buscaPetsDoClienteComID");
		var pets = petSpringDataJPARepository.findByIdClienteTutor(idCliente);
		log.info("[finish] PetInfraRepository - buscaPetsDoClienteComID");
		return pets;
	}

	@Override
	public Pet buscaPetPeloId(UUID idPet) {
		log.info("[start] PetInfraRepository - buscaPetPeloId");
		var pet = petSpringDataJPARepository.findById(idPet)
				.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Pet não encontrado para o id" + idPet));
		log.info("[finish] PetInfraRepository - buscaPetPeloId");
		return pet;
	}

}
