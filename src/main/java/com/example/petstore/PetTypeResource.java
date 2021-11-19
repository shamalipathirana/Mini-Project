package com.example.petstore;

import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.json.JSONException;
import org.json.JSONObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;


@Path("/pettypes")
@Produces("application/json")
@Consumes("application/json")
public class PetTypeResource {

    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "All Pet Types", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "PetType ")))
    })

    @GET
    public Response getPetTypes(){
        return Response.ok(PetTypeList.getInstance().getArrayList()).build();
    }

    @Path("/add")
    @Produces("application/json")
    @POST
    public Response addPetType(String petTypeData) throws JSONException {

        JSONObject jsonObject = new JSONObject(petTypeData);

        PetTypes petType = new PetTypes();
        List<PetTypes> petTypes = new ArrayList<PetTypes>();
        List<PetTypes> temp = new ArrayList<PetTypes>();

        if(jsonObject.has("petType") && jsonObject.has("petsQuantity")){
            String petTypeName = jsonObject.getString("petType");
            int petsQuantity = Integer.parseInt(jsonObject.getString("petsQuantity"));
            petType.setPetTypeId(PetTypeList.getInstance().getArrayList().get(PetTypeList.getInstance().getArrayList().size()-1).getPetTypeId()+1);
            petType.setPetType(petTypeName);
            petType.setPetsQuantity(petsQuantity);
            petTypes.add(petType);
            temp.addAll(PetTypeList.getInstance().getArrayList());
            temp.addAll(petTypes);
            PetTypeList.getInstance().setArrayList(temp);
            //petData.addData(pet);
            return Response.ok(petType).build();
        }else{
            return Response.ok("{\n" + "\"successful\":false\n" + "}").build();
        }
    }

    @DELETE
    @Produces("application/json")
    @Path("/delete/{petTypeId}")
    public Response deletePetType(@PathParam("petTypeId") int petTypeId){
        boolean isPetFound = false;
        for (int i=0;i<PetTypeList.getInstance().getArrayList().size();i++){
            if(petTypeId == PetTypeList.getInstance().getArrayList().get(i).getPetTypeId()){
                PetTypeList.getInstance().getArrayList().remove(i);
                isPetFound = true;
            }
        }
        if(isPetFound){
            return Response.ok("{\n" + "\"successful\":true\n" + "}").build();
        }else{
            return Response.ok("{\n" + "\"successful\":false\n" + "}").build();
        }

    }

    @PUT
    @Produces("application/json")
    @Path("/edit/{petTypeId}")
    public Response editPetType(@PathParam("petTypeId") int petTypeId,String petTypeData) throws JSONException {
        JSONObject jsonObject = new JSONObject(petTypeData);
        boolean isUpdated = false;
        int id = 0;
        if(jsonObject.has("petType")){
            for (int i=0;i<PetTypeList.getInstance().getArrayList().size();i++){
                if(petTypeId == PetTypeList.getInstance().getArrayList().get(i).getPetTypeId()){
                    PetTypeList.getInstance().getArrayList().get(i).setPetType(jsonObject.getString("petType"));
                    isUpdated=true;
                    id=i;
                }
            }
        }
        if(jsonObject.has("petsQuantity")){
            for (int i=0;i<PetTypeList.getInstance().getArrayList().size();i++){
                if(petTypeId == PetTypeList.getInstance().getArrayList().get(i).getPetTypeId()){
                    PetTypeList.getInstance().getArrayList().get(i).setPetsQuantity(Integer.parseInt(jsonObject.getString("petsQuantity")));
                    isUpdated=true;
                    id=i;
                }
            }
        }
        if(isUpdated){
            return Response.ok(PetTypeList.getInstance().getArrayList().get(id)).build();
        }else{
            return Response.ok("{\n" + "\"successful\":false\n" + "}").build();
        }

    }


}
