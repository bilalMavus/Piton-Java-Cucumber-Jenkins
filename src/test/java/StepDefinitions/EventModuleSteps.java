package StepDefinitions;

import Pages.EventModulePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;

import java.util.List;

public class EventModuleSteps {
    EventModulePage emp = new EventModulePage();

    @And("Click on the element")
    public void clickOnTheElement(DataTable value) { //DataTable kullanımı için yaptım
        List<String> listElemanlar = value.asList(String.class); // Gelen değerleri listeye atıyorum.
        for (String strButtonName : listElemanlar) {
            emp.findAndClick(strButtonName);  // Listeden gelen elementlere tıklama işlemi yapıyorum
        }
    }

    @And("Does it contain elements")
    public void doesItContainElements(DataTable value) { //DataTable kullanımı için yaptım
        List<String> listElemanlar = value.asList(String.class); // Gelen değerleri listeye atıyorum.
        for (String strButtonName : listElemanlar) {
            emp.containElement(strButtonName);  // Listeden gelen elementlere element var mı sorgusu yapıyorum
        }
    }

    @And("Are validation errors displayed")
    public void areValidationErrorsDisplayed(DataTable value) { //DataTable kullanımı için yaptım
        List<List<String>> listElemanlar= value.asLists(String.class); // Gelen değerleri 2D listeye atıyorum.
        for(int i=0;i< listElemanlar.size() ; i++ )
            emp.findAndContainsText(listElemanlar.get(i).get(0), listElemanlar.get(i).get(1) ); //1. turda elementin adı, 2. turda textini alıyorum ve doğrulamaya gönderiyorum.
    }

    @And("Successful verification displayed")
    public void successfulVerificationDisplayed(DataTable value) { //DataTable kullanımı için yaptım
        List<List<String>> listElemanlar= value.asLists(String.class); // Gelen değerleri 2D listeye atıyorum.
        for(int i=0;i< listElemanlar.size() ; i++ )
            emp.findAndContainsText(listElemanlar.get(i).get(0), listElemanlar.get(i).get(1) ); //1. turda elementin adı, 2. turda textini alıyorum ve doğrulamaya gönderiyorum.
    }

    @And("Sending the keys in Event content")
    public void sendingTheKeysInEventContent(DataTable value) { //DataTable kullanımı için yaptım
        List<List<String>> listElemanlar= value.asLists(String.class); // Gelen değerleri 2D listeye atıyorum.
        for(int i=0;i< listElemanlar.size() ; i++ )
            emp.findAndSend(listElemanlar.get(i).get(0), listElemanlar.get(i).get(1) ); //1. turda elementin adı, 2. turda textini alıyorum ve elemente veri giriyorum.
    }
}