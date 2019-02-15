package io.github.chrislo27.rhre3.playalong

import com.badlogic.gdx.Input


data class PlayalongControls(var buttonA: Int = Input.Keys.J,
                             var buttonB: Int = Input.Keys.K,
                             var buttonLeft: Int = Input.Keys.A,
                             var buttonRight: Int = Input.Keys.D,
                             var buttonUp: Int = Input.Keys.W,
                             var buttonDown: Int = Input.Keys.S) {

    companion object {
        val QWERTY_D_PAD_LEFT: PlayalongControls = PlayalongControls()

    }

    fun toInputMap(): Map<PlayalongInput, Set<Int>> {
        return linkedMapOf(PlayalongInput.BUTTON_A to setOf(buttonA),
                           PlayalongInput.BUTTON_B to setOf(buttonB),
                           PlayalongInput.BUTTON_DPAD_UP to setOf(buttonUp),
                           PlayalongInput.BUTTON_DPAD_DOWN to setOf(buttonDown),
                           PlayalongInput.BUTTON_DPAD_LEFT to setOf(buttonLeft),
                           PlayalongInput.BUTTON_DPAD_RIGHT to setOf(buttonRight),
                           PlayalongInput.BUTTON_A_OR_DPAD to setOf(buttonA, buttonUp, buttonDown, buttonLeft, buttonRight),
                           PlayalongInput.BUTTON_DPAD to setOf(buttonUp, buttonDown, buttonLeft, buttonRight)
                          )
    }

    fun toInputString(): String {
        val inputMap = linkedMapOf(PlayalongInput.BUTTON_A to setOf(buttonA),
                                   PlayalongInput.BUTTON_B to setOf(buttonB),
                                   PlayalongInput.BUTTON_DPAD_UP to setOf(buttonUp),
                                   PlayalongInput.BUTTON_DPAD_DOWN to setOf(buttonDown),
                                   PlayalongInput.BUTTON_DPAD_LEFT to setOf(buttonLeft),
                                   PlayalongInput.BUTTON_DPAD_RIGHT to setOf(buttonRight)
                                  )
        return inputMap.entries.joinToString(separator = "  [GRAY]|[]  ") { (k, v) -> "${k.longDisplayText} - ${v.joinToString(separator = ", ") { Input.Keys.toString(it)}}" }
    }

}