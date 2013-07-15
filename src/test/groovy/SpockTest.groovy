import geb.spock.GebSpec

class SpockTest extends GebSpec {
    def "enter new user data"() {
        given:
          "on the userdata page"
          to UserDataPage

        when:
          "form filled with ..."
          userDataForm.with {
              name = "Rolf"
              surname = "Roessing"
              age = "22"

          }
          report "form screen"

        and:
          "form submitted"
          saveButton.click()


        then:
          "page is shown"
          at SavePage

    }

    def "show specific user data"() {
        given:
          "on the user data page"
          to UserDataPage

        when:
          "form is filled with name: name_1"
          nameForm.with {
              name = "name_1"
          }

        and:
          "form is submitted"
          searchButton.click()

        then:
          "out page is shown and the response contains \"name_!\" "
          at SavePage
          def res = userDataResponse.text()
          assert res.contains('name_1'), 'result should contain \"name_1\" but was ' + res

    }


}