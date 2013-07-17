package steps
import pages.UserDataPage
import pages.SavePage

this.metaClass.mixin(cucumber.api.groovy.EN)


//## common
Given(~'^I am on the user data page$') {  ->
    to UserDataPage
    waitFor { at(UserDataPage) }
}


//# Scenario see a list of user data
When(~"^I do nothing else") { ->
   // page.searchField.value(query)
    //page.searchButton.click()
}
Then(~"^a list of all demo user data is shown") {  ->
    assert at(page)
    page.userDataList.size() >10
    page.userDataList.first().text() =~ 'name_13'
    page.firstUserDataFromListText =~ 'name'
    println 'heading =' +  page.heading.text()
}


//# Scenario: See a special user data
When(~'^I search for user data by name = "([^"]*)"$') { name ->

        page.nameForm.name = name
        page.searchButton.click()

}
Then(~'^the user data containing "([^"]*)" is shown below the search form$') { String name ->
    page.userDataResponse.text() =~  name
    println 'page.userDataResponse.text():' + page.userDataResponse.text()
}

//# Scenario: Add a new user data
When(~'^I fill out the user data form with name: "([^"]*)" , surname: "([^"]*)" and age: "(\\d+)$'){
    String name, String surname, String age ->
        page.userDataForm.name = name
        page.userDataForm.surname = surname
        page.userDataForm.age = age
        page.saveButton.click()
}

Then(~"^I am at the save results page"){ ->
   page.at
}



