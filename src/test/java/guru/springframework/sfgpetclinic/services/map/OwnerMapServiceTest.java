package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Owner Map Service Test - ")
class OwnerMapServiceTest {

    OwnerMapService ownerMapService;
    PetTypeService petTypeService;
    PetService petService;

    @BeforeEach
    void setUp() {
        petTypeService = new PetTypeMapService();
        petService = new PetMapService();
        ownerMapService = new OwnerMapService(petTypeService, petService);
        System.out.println("First Before Each");
    }

    @DisplayName("Verify Zero Owners")
    @Test
    void ownersAreZero() {
        int ownerCount = ownerMapService.findAll().size();
        assertThat(ownerCount).isZero();
    }

    @DisplayName("Pet Type - ")
    @Nested
    class TestCreatePetTypes {

        @BeforeEach
        void setUp() {
            PetType petTypeDog = new PetType(1l, "Dog");
            PetType petTypeCat = new PetType(2l, "Cat");
            petTypeService.save(petTypeDog);
            petTypeService.save(petTypeCat);

            System.out.println("Nested Before Each");
        }

        @Test
        void petCount() {
            int petTypeCount = petTypeService.findAll().size();
            assertThat(petTypeCount).isNotZero().isEqualTo(2);
        }

        @DisplayName("Save Owners Test - ")
        @Nested
        class SaveOwnersTest {
            @BeforeEach
            void setUp() {
                ownerMapService.save(new Owner(1l, "Before", "Each"));
                System.out.println("Saved Owners Before Each");
            }

            @Test
            void saveOwner(){
                Owner owner = new Owner(2l, "Joe", "Buck");
                Owner savedOwner = ownerMapService.save(owner);
                assertThat(savedOwner).isNotNull();
            }

            @DisplayName("Find Owners Test - ")
            @Nested
            class FindOwnersTest{

                @DisplayName("Find Owner")
                @Test
                void findOwner(){

                    Owner foundOwner = ownerMapService.findById(1l);
                    assertThat(foundOwner).isNotNull();
                }

                @DisplayName("Find Owner Not Found")
                @Test
                void findOwnerNotFound(){

                    Owner foundOwner = ownerMapService.findById(1l);
                    assertThat(foundOwner).isNotNull();
                }
            }
        }

    }

    @DisplayName("Verify Still Zero Owners")
    @Test
    void ownersAreStillZero() {
        int ownerCount = ownerMapService.findAll().size();
        assertThat(ownerCount).isZero();
    }
}