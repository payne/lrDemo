import geb.Page

class UserDataPage extends Page {
    static url = "http://localhost:8081/userdata"
    static at = { title == "userData" }
    static content = {
        heading { $("h2") }
        userDataForm { $ { '#newUserDataForm' } }
        saveButton(to: SavePage) { $('#submitNewUserDataForm') }

        nameForm { $ { '#nameForm' } }
        searchButton(to: SavePage) { $('#submitNameForm') }

    }
}


class SavePage extends Page {
    static at = { title == "userData" }
    static content = {
        heading { $("h2") }
        userDataResponse { $("#userDataResponse") }
    }


}