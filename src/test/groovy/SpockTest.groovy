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
              name = theName
          }
         println logStr

        and:
          "form is submitted"
          searchButton.click()

        then:
          "out page is shown and the response contains \"name_!\" "
          at SavePage
          def res = userDataResponse.text()
          assert res.contains(theName), 'result should contain \"name_1\" but was ' + res

        //run this test with parameters in interation.... Yiha!
        where:
          theName | logStr
          "name_1"| "try name 1"
          "name_2"| "try name 2"
          "name_3"| "try name 3"
          "name_4"| "try name 4"
          "name_5"| "try name 5"
          "name_6"| "try name 6"
          "name_7"| "try name 7"
          "name_8"| "try name 8"

    }


}