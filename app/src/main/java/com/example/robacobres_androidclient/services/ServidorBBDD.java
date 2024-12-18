package com.example.robacobres_androidclient.services;

import com.example.robacobres_androidclient.models.ChangePassword;
import com.example.robacobres_androidclient.models.ChatIndividual;
import com.example.robacobres_androidclient.models.Forum;
import com.example.robacobres_androidclient.models.GameCharacter;
import com.example.robacobres_androidclient.models.Item;
import com.example.robacobres_androidclient.models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ServidorBBDD {
    //SERVICE USERS
    //register user
    @POST("users/register") //OK
    Call<User> registerUser(@Body User user);

    @GET("users/GetCode")
    Call<Void> getCode();

    //change correo user
    @PUT("users/ChangeMail/{NewCorreo}/{code}")
    Call<Void> UserChangeCorreo(@Path("NewCorreo") String NewCorreo,@Path("code") String code);
    //login user
    @POST("users/login") //OK
    Call<Void> loginUser(@Body User user);

    //delete user
    @DELETE("users/deleteUser") //OK
    Call<Void> deleteUser();

    //recover password user
    @GET("users/RecoverPassword/{UserName}")
    Call<Void> RecoverPassword(@Path("UserName") String username);

    //change password user
    @PUT("users/ChangePassword")
    Call<Void> UserChangePassword(@Body ChangePassword passwords);

    //SERVICE ITEMS
    //get all items
    @GET("items")
    Call<List<Item>> getItems();

    @GET("store/Items")
    Call<List<Item>> getMyItems();

    //get a specific item
    @GET("items/{ItemName}") //ARREGLAR
    Call<Item> getItem(@Path("ItemName") String ItemName);

    @GET("users/sessionCheck")
    Call<Void> getSession();

    @GET("users/sessionOut")
    Call<Void> quitSession();

    @GET("users/GetMultiplicadorForCobre")
    Call<String> UserGetsMultiplicador();

    @GET("users/stats")
    Call<User> GetStatsUser();

    //GetUser
    @POST("users/stats") //OK
    Call<User> getUser();

    @POST("users/sellCobre/{KilosCobre}")
    Call<User> UserSellsCobre(@Path("KilosCobre") Double kiloscobre);

    @POST("store/buyItem/{itemName}")
    Call<List<Item>> userBuysItem(@Path("itemName") String itemName);

    @POST("store/buyCharacters/{CharacterName}")
    Call<List<GameCharacter>> userBuysCharacter(@Path("CharacterName") String CharacterName);

    @POST("users/GetForum") //OK
    Call<List<Forum>> getForum();

    @POST("users/PostInForum") //OK
    Call<List<Forum>> PostInForum(@Body Forum forum);

    @POST("users/PrivateNames") //OK
    Call<List<User>> getPrivateNames();

    @POST("users/PrivateMessagesWith/{name}") //OK
    Call<List<ChatIndividual>> getPrivateMessagesWith(@Path("name") String name);

    @POST("users/PrivateChat/Post") //OK
    Call<List<ChatIndividual>> postPrivateMessage(@Body ChatIndividual chatIndividual);

    @GET("store/ItemsUserCanBuy") //ARREGLAR
    Call<List<Item>> getItemssUserCanBuy();

    @GET("store/CharactersUserCanBuy") //ARREGLAR
    Call<List<GameCharacter>> getCharactersUserCanBuy();


    /*
    //DELETE
    @DELETE("tracks/{id}")
    Call<Void> deleteTrack(@Path("id") String id);


    //PUT
    @PUT("tracks")
    Call<Void> putTrack(@Body Track track);

    //POST
    @POST("tracks")
    Call<Track> postTrack(@Body Track track);
     */
}
