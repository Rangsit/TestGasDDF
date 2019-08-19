import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW

WebUI.openBrowser('')

WebUI.navigateToUrl('http://www.calculator.net/gas-mileage-calculator.html#')

WebUI.click(findTestObject('GasOR/Page_Gas Mileage Calculator/us_metrix'))

for (int i = 1; i <= findTestData('GasTest Data').getRowNumbers(); i++) {
    WebUI.setText(findTestObject('GasOR/Page_Gas Mileage Calculator/input_uscodreading'), 
		          findTestData('GasTest Data').getValue(1, i))

    WebUI.setText(findTestObject('GasOR/Page_Gas Mileage Calculator/input_uspodreading'), findTestData('GasTest Data').getValue(
            2, i))

    WebUI.setText(findTestObject('GasOR/Page_Gas Mileage Calculator/input_usgasputin'), findTestData('GasTest Data').getValue(
            3, i))

    WebUI.setText(findTestObject('GasOR/Page_Gas Mileage Calculator/input_usgasprice'), findTestData('GasTest Data').getValue(
            4, i))

    WebUI.click(findTestObject('GasOR/Page_Gas Mileage Calculator/input'))

    result = WebUI.getText(findTestObject('GasOR/Page_Gas Mileage Result/consumption'))

    WebUI.verifyMatch(result, findTestData('GasTest Data').getValue(5, i), false, FailureHandling.OPTIONAL)
}

