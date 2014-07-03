package polymersandbox

import scala.scalajs.js
import scala.scalajs.js.Dynamic.{global => g, literal => lit}
import scala.scalajs.js.JSApp

object PolymerSandbox extends JSApp {
  def main(): Unit = {
    g.Polymer("my-element", lit(
      age = 25,
      name = "Walter",
      color = "red",
      owner = "eric",
      created = thisFunc(_ => g.console.log("element created")),
      nameChanged = thisFunc(thiz => {
        if (!(!thiz.name))
          thiz.name = thiz.name.charAt(0).toUpperCase() + thiz.name.slice(1)
      }),
      setFocus = thisFunc(thiz => thiz.$.nameInput.focus())
    ))
    g.Polymer("my-element2", lit(
      name = "Chang"
    ))
  }
  def thisFunc(f: js.Dynamic => js.Any): js.ThisFunction0[js.Dynamic, js.Any] = f
}
