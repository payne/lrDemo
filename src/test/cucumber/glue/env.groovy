package env

import geb.Browser
import geb.binding.BindingUpdater

this.metaClass.mixin(cucumber.api.groovy.Hooks)

def bindingUpdater
Before() { scenario ->
	bindingUpdater = new BindingUpdater(binding, new Browser())
	bindingUpdater.initialize()
}

After() { scenario ->
	bindingUpdater.remove()
}