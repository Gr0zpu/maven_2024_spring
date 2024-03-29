package api;

import com.saucedemo.core.BaseSeleniumTest;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class ReqresTest{
    private final static String URL = "https://reqres.in/";

   @Test
    public void checkAvatarAndId(){
       Specification.installSpecification(Specification.requestSpec(URL), Specification.responseSpec(200));
        List<UserData> users = given()
                .when()

                .get("api/users?page=2")
                .then().log().all()
                .extract().body().jsonPath().getList("data", UserData.class);

        users.forEach(a -> Assert.assertTrue(a.getAvatar().contains(a.getId().toString())));




    }
    @Test
    public void emailTest(){
        List<UserData> users = given()
                .when()
                .contentType(ContentType.JSON)
                .get(URL + "api/users?page=2")
                .then().log().all()
                .extract().body().jsonPath().getList("data", UserData.class);

        Assert.assertTrue(users.stream().allMatch(a -> a.getEmail().endsWith("@reqres.in")));
    }

    @Test
    public void successRegTest(){
        Specification.installSpecification(Specification.requestSpec(URL),Specification.responseSpec(200));
        Integer id = 4;
        String token = "QpwL5tke4Pnpja7X4";

        Register user = new Register("eve.holt@reqres.in","pistol");
        SuccessReg successReg = given()
                .body(user)
                .when()
                .post("api/register")
                .then().log().all()
                .extract().as(SuccessReg.class);
        Assert.assertNotNull(successReg.getId());
        Assert.assertNotNull(successReg.getToken());
        Assert.assertEquals(id, successReg.getId());
        Assert.assertEquals(token, successReg.getToken());
    }

    @Test
    public void unSuccessRegTest(){
       Specification.installSpecification(Specification.requestSpec(URL),Specification.responseSpec(400));
       Register user = new Register("sydney@fife", "");
       UnSuccessReg unSuccessReg = given()
               .body(user)
               .post("api/register")
               .then().log().all()
               .extract().as(UnSuccessReg.class);

       Assert.assertEquals("Missing password", unSuccessReg.getError());


    }



}
