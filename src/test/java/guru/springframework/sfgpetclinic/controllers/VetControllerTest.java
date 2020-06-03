package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.ControllersTest;
import guru.springframework.sfgpetclinic.fauxspring.Model;
import guru.springframework.sfgpetclinic.fauxspring.ModelMapImpl;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.SpecialityMapService;
import guru.springframework.sfgpetclinic.services.map.VetMapService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class VetControllerTest implements ControllersTest {

    VetService vetService;
    SpecialtyService specialtyService;
    VetController vetController;

    @BeforeEach
    void setUp() {
        specialtyService = new SpecialityMapService();
        vetService = new VetMapService(specialtyService);
        vetController = new VetController(vetService);
        Vet vet1 = new Vet(1l, "Vet1", "Bla", null);
        Vet vet2 = new Vet(2l, "Vet2", "Bla2", null);

        vetService.save(vet1);
        vetService.save(vet2);
    }

    @Test
    void listVets() {
        Model model = new ModelMapImpl();
        String view = vetController.listVets(model);
        assertThat("vets/index").isEqualTo(view);
        Set modelAttribute = (Set) ((ModelMapImpl)model).getMap().get("vets");
        assertThat(modelAttribute.size()).isEqualTo(2);
    }
}