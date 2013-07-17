package pages

import geb.Page

class UserDataPage extends Page {
    static url = "http://localhost:8081/userdata"
    static at = {getUrl() == url }
    static content = {
        heading { $("h2") }
        userDataForm { $ ( '#newUserDataForm' ) }
        saveButton(to: SavePage) { $('#submitNewUserDataForm') }

        nameForm { $('#nameForm')  }
        searchButton(to: SavePage) { $('#submitNameForm') }
        userDataList{ $('div.userData') }
        firstUserDataFromListText{ $('div.userData',0).text() }
    }
}


class SavePage extends Page {
    static at = {getTitle() == 'userData' }
    static content = {
        heading { $("h2") }
        userDataResponse { $("#userDataResponse") }
    }


}