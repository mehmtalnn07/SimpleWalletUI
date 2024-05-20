package com.mehmetalan.walletapp.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Wallet
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.mehmetalan.walletapp.data.BottomNavigationItem

val items = listOf(
    BottomNavigationItem(
        title = "Home",
        icon = Icons.Outlined.Home
    ),
    BottomNavigationItem(
        title = "Wallet",
        icon = Icons.Outlined.Wallet
    ),
    BottomNavigationItem(
        title = "Notifications",
        icon = Icons.Outlined.Notifications
    ),
    BottomNavigationItem(
        title = "Account",
        icon = Icons.Outlined.Person
    )
)

@Preview
@Composable
fun BottomNavigationBar() {
    NavigationBar {
        Row (
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.inverseOnSurface)
        ) {
            items.forEachIndexed { index, item ->
                NavigationBarItem(
                    selected = index == 0,
                    onClick = {

                    },
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.title,
                            tint = MaterialTheme.colorScheme.onBackground
                        )
                    },
                    label =  {
                        Text(
                            text = item.title,
                            color = MaterialTheme.colorScheme.onBackground,
                            fontWeight = FontWeight.ExtraBold
                        )
                    }
                )
            }
        }
    }
}