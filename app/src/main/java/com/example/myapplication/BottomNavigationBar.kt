package com.example.myapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.myapplication.models.BottomNavItem

val items = listOf(
    BottomNavItem(
        title = "Home",
        icon = Icons.Rounded.Home
    ),
    BottomNavItem(
        title = "Wallet",
        icon = Icons.Rounded.Wallet
    ),
    BottomNavItem(
        title = "Notifications",
        icon = Icons.Rounded.Notifications
    ),
    BottomNavItem(
        title = "Account",
        icon = Icons.Rounded.AccountCircle
    )
)

@Composable
fun BottomNavigationBar() {
    NavigationBar {
        Row (
            modifier = Modifier.background(MaterialTheme.colorScheme.inverseOnSurface)
        ){
            items.forEachIndexed{ index, bottomNavItem ->
                NavigationBarItem(
                    selected = index == 0,
                    onClick = { },
                    icon = {
                        Icon(
                            imageVector = bottomNavItem.icon,
                            contentDescription = bottomNavItem.title,
                            tint = MaterialTheme.colorScheme.onBackground
                        )
                    },
                    label = {
                        Text(text = bottomNavItem.title,
                            color = MaterialTheme.colorScheme.onBackground)
                    }
                )
            }
        }
    }
}