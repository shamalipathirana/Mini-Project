package com.example.petstore;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(name = "PetType")
public class PetTypes {

    @Schema(required = true, description = "Pet type id")
    @JsonProperty("pet_type_id")
    private Integer petTypeId;

    @Schema(required = true, description = "Pet type")
    @JsonProperty("pet_type")
    private String petType;

    @Schema(required = true, description = "Pet type quantity")
    @JsonProperty("pets_quantity")
    private Integer petsQuantity;

    public Integer getPetTypeId() {
        return petTypeId;
    }

    public void setPetTypeId(Integer petTypeId) {
        this.petTypeId = petTypeId;
    }

    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    public Integer getPetsQuantity() {
        return petsQuantity;
    }

    public void setPetsQuantity(Integer petsQuantity) {
        this.petsQuantity = petsQuantity;
    }
}
