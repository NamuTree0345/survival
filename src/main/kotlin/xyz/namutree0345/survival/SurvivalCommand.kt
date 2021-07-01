package xyz.namutree0345.survival

import io.github.monun.kommand.KommandDispatcherBuilder

object SurvivalCommand {

    fun init(builder: KommandDispatcherBuilder) {
        builder.register("survival") {
            then("start") {
                executes {

                }
            }
        }

    }

}