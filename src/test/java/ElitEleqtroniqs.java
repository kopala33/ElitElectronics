import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Driver;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class ElitEleqtroniqs {


    @Test
    public void elitTest() {

        /**
         * გახსენით ee.ge - ს ლინკი
         * ტესტ მეთოდი 1 - დადებითი მნიშვნელობები
         * გადადით რეგისტრაციის გვერდზე
         * შეამოწმეთ რომ ნამდვილად რეგისტრაციის გვერდზე ხართ
         * შეავსეთ სახელის ველი, დარწმუნდით რომ მონაცემი ჩაიწერა ანუ ველი არ არის ცარიელი
         * შეავსეთ გვარის ველი, დარწმუნდით რომ მონაცემი ჩაიწერა ანუ ველი არ არის ცარიელი
         * შეავსეთ მეილის ველი სწორი მნიშვნელობით , დარწმუნდით რომ მონაცემი ჩაიწერა ანუ
         * ველი არ არის ცარიელი
         * შეავსეთ პაროლის ველი
         * შეავსეთ გაიმეორეთ პაროლის ველი
         * შეამოწმეთ რომ რეგისტრაციის ღილაკი არის Enabled
         */

        Configuration.browserSize = "3840x2160";
        open("https://ee.ge/");
        $(byText("რეგისტრაცია")).click();
        $(byText("სწრაფი რეგისტრაცია")).shouldBe(Condition.visible, Duration.ofMillis(2000));
        $("#firstName").setValue("Data");
        $("#firstName").shouldNotBe(Condition.empty); // ესეთი თანმიმდევრობითაც შეიძლება
        $("#lastName").setValue("kopala");
        $("#lastName").shouldNotBe(Condition.empty);
        $("#email").setValue("shxamiani@gmail.com").shouldBe(Condition.visible); // და ესეც
        $("#password").setValue("12345678").shouldBe(Condition.visible);
        $("#confirmPassword").setValue("12345678").shouldBe(Condition.visible);
        $("#singup").shouldBe(Condition.enabled);


    }

    @Test
    public void elitTest2() {

        /**
         * ტესტ მეთოდი 2 - ნეგატიური მნიშვნელობები
         * გადადით რეგისტრაციის გვერდზე
         * შეამოწმეთ რომ ნამდვილად რეგისტრაციის გვერდზე ხართ
         * შეამოწმეთ რომ 'რეგისტრაცია' ღილაკი არის Disabled
         * შეამოწმეთ ველების მანდატორობა, ველში დაკლიკების შემდეგ სხვა ველზე
         * დაკლიკებით გამოაქვს შეტყობინება, შეამოწმეთ ხუთივე ველის შეტყობინება
         * ელ-ფოსტის ველში ჩაწერეთ არასწორი მეილის ფორმატით მნიშვნელობა, შეამოწმეთ რომ არ ქრება შეტყობინება
         * შეამოწმეთ პაროლის ველი 6 სიმბოლოზე ნაკლების შეყვანის შემთხვევაშ არ უნდა გაქრეს შეტყობინება
         * გაიმეორეთ პაროლის ველში პაროლის ველისგან განსხვავებული მნიშვნელობის
         * ჩაწერისას არ უნდა გაქრეს შეტყობინება
         */

        Configuration.browserSize = "3840x2160";
        open("https://ee.ge/registration");
        $(byText("სწრაფი რეგისტრაცია")).shouldBe(Condition.visible);
        $("#singup").shouldBe(Condition.disabled);
        $("#firstName").click();
        $("#lastName").click();
        $(byText("სახელი სავალდებულოა")).shouldBe(Condition.visible);
        $("#email").click();
        $(byText("გვარი სავალდებულოა")).shouldBe(Condition.visible);
        $("#password").click();
        $(byText("ელ. ფოსტა სავალდებულოა")).shouldBe(Condition.visible);
        $("#confirmPassword").click();
        $(byText("პაროლი სავალდებულოა.")).shouldBe(Condition.visible);
        $("#email").click();
        $(byText("პაროლის გამეორება სავალდებულოა")).shouldBe(Condition.visible);

        $(byId("email")).setValue("rogorxart");
        $(byId("firstName")).click();
        $(byText("ელ. ფოსტა სავალდებულოა")).shouldBe(Condition.visible);
        $(byId("password")).setValue("12345");
        $(byId("confirmPassword")).click();
        $(byText("პაროლი სავალდებულოა.")).shouldBe(Condition.visible);
        $(byId("password")).setValue("123333");
        $(byId("confirmPassword")).setValue("dddttt");
        $(byId("firstName")).click();
        $(byText("პაროლის გამეორება სავალდებულოა")).shouldBe(Condition.visible);


    }

    @Test
    public void elitTest3() {

        /**
         * ტესტ მეთოდი 3
         * გადადით კალათაში და დარწმუნდით რომ ცარიელია
         * დასერჩეთ ნებისმიერი რაღაც რასაც შედეგი ექნება, მაგალითად კომპიუტერი,
         * ექნება, მაგალითად კომპიუტერი, პირეველივე შედეგი დაამატეთ კალათაში
         * გადადით კალათაში ნახეთ რომ კალათა აღარაა ცარიელი
         * წაშალეთ კალათიდან პროდუქტი
         * დარწმუნდით რომ კალათა კვლავ ცარიელია
         */

        Configuration.browserSize = "3840x2160";
        open("https://ee.ge/registration");
        $(byAttribute("class", "cart")).click();
        $(byText("კალათა ცარიელია")).shouldBe(Condition.visible);
        $("#search_list").setValue("კომპიუტერი");
        $(".btn").click();
        $(byText("დაამატე კალათში"), 0).click();
        $(".cart").click();
        $(byText("დაამატე კალათში"), 0).shouldNotBe(Condition.empty);
        $(".items", 0).click();
        $(byText("კალათა ცარიელია")).shouldBe(Condition.visible);



    }

    @Test
    public void elitTest4() {


        /**
         * ტესტ მეთოდი 4
         * გადადით კალათაში და დარწმუნდით რომ ცარიელია
         * გადადით შენახულ ნივთებში და დარწმუნდით რომ ცარიელია
         * დასერჩეთ ნებისმიერი რაღაც რასაც შედეგი ექნება, მაგალითად კომპიუტერი,
         * პირეველივე შედეგი დაამატეთ კალათაში
         * გადაით კალათაში და შეინახეთ მოცემული პროდუქტი
         * გადადით შენახულ ნივთებში და შეამოწმეთ რომ აღარაა ცარიელი
         * გადადით კალათაში და დარწუნდით რომ კალათიდან ავტოატურად წაიშალა პროდუქტი
         * გადადით შენახულ ნივთებში წაშალეთ შენახული პროდუქტი
         * დარწმუნდით რომ შენახული ნივთები ცარიელია
         */

        Configuration.browserSize = "3840x2160";
        open("https://ee.ge/");
        $(byAttribute("class", "cart")).click();
        $(byText("კალათა ცარიელია")).shouldBe(Condition.visible);
        $(byText("შენახული ნივთები")).click();
        $(byText("ვერ მოიძებნა")).shouldBe(Condition.visible);
        $("#search_list").setValue("კომპიუტერი").click();
        $(".btn").click();
        $(byText("დაამატე კალათში"), 0).click();
        $(".cart").click();
        $(byText("შენახვა")).click();
        $(byText("შენახული ნივთები")).shouldNotBe(Condition.empty);
        $(byAttribute("class", "cart")).click();
        $(byText("კალათა ცარიელია")).shouldBe(Condition.visible);
        $(byText("შენახული ნივთები")).click();
        $(byXpath("//i[@class='fa fa-times']")).click();
        $(byText("ვერ მოიძებნა")).shouldBe(Condition.visible);



    }


}


