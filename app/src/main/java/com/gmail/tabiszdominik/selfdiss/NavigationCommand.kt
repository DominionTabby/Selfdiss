package com.gmail.tabiszdominik.selfdiss

/**
 * Created by Dominik Tabisz on 2019-09-28.
 * tabiszdominik@gmail.com
 */
sealed class NavigationCommand {
    object OpenSettings : NavigationCommand()
}