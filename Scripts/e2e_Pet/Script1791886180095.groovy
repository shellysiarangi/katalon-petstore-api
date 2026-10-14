import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

CustomKeywords.'pet_store.Pet.generatePetData'()

// Post Pet
def ResponsePost = CustomKeywords.'pet_store.Post_Pet.postPet'(GlobalVariable.pet_id, GlobalVariable.pet_name, GlobalVariable.pet_status)

CustomKeywords.'pet_store.Pet.verifyStatusCode'(ResponsePost, GlobalVariable.success)

CustomKeywords.'pet_store.Pet.verifyPetData'(ResponsePost, GlobalVariable.pet_id, GlobalVariable.pet_name, GlobalVariable.pet_status)

// Get Pet
def ResponseGet = CustomKeywords.'pet_store.Get_Pet.getPet'(GlobalVariable.pet_id)

CustomKeywords.'pet_store.Pet.verifyStatusCode'(ResponseGet, GlobalVariable.success)

CustomKeywords.'pet_store.Pet.verifyPetData'(ResponseGet, GlobalVariable.pet_id, GlobalVariable.pet_name, GlobalVariable.pet_status)

// Put Pet
def ResponsePut = CustomKeywords.'pet_store.Put_Pet.putPet'(GlobalVariable.pet_id, GlobalVariable.pet_name_update, GlobalVariable.pet_status_update)

CustomKeywords.'pet_store.Pet.verifyStatusCode'(ResponsePut, GlobalVariable.success)

CustomKeywords.'pet_store.Pet.verifyPetData'(ResponsePut, GlobalVariable.pet_id, GlobalVariable.pet_name_update, GlobalVariable.pet_status_update)

// Get Pet Update
def ResponseGetUpdate = CustomKeywords.'pet_store.Get_Pet.getPet'(GlobalVariable.pet_id)

CustomKeywords.'pet_store.Pet.verifyStatusCode'(ResponseGetUpdate, GlobalVariable.success)

CustomKeywords.'pet_store.Pet.verifyPetData'(ResponseGetUpdate, GlobalVariable.pet_id, GlobalVariable.pet_name_update, GlobalVariable.pet_status_update)

// Delete Pet
def ResponseDelete = CustomKeywords.'pet_store.Delete_Pet.deletePet'(GlobalVariable.pet_id)

CustomKeywords.'pet_store.Pet.verifyStatusCode'(ResponseDelete, GlobalVariable.success)

CustomKeywords.'pet_store.Pet.verifyMessage'(ResponseDelete, GlobalVariable.pet_id)

// Verify Get Terhapus
def ResponseGetHapus = CustomKeywords.'pet_store.Get_Pet.getPet'(GlobalVariable.pet_id)

CustomKeywords.'pet_store.Pet.verifyStatusCode'(ResponseGetHapus, GlobalVariable.not_found)

CustomKeywords.'pet_store.Pet.verifyMessage'(ResponseGetHapus, GlobalVariable.message_not_found)