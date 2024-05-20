package com.mehmetalan.walletapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Analytics
import androidx.compose.material.icons.outlined.MonetizationOn
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.outlined.Wallet
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mehmetalan.walletapp.data.Finance

val financeList = listOf(
    Finance(
        icon = Icons.Outlined.Star,
        name = "My\nBusiness",
        backgroundColor = Color.Black
    ),
    Finance(
        icon = Icons.Outlined.Wallet,
        name = "My\nWallet",
        backgroundColor = Color.Black
    ),
    Finance(
        icon = Icons.Outlined.Analytics,
        name = "Finance\nAnalytics",
        backgroundColor = Color.Black
    ),
    Finance(
        icon = Icons.Outlined.MonetizationOn,
        name = "My\nTransactions",
        backgroundColor = Color.Black
    ),
)

@Preview
@Composable
fun FinanceSection() {
    Column {
        Text(
            text = "Finance",
            fontSize = 24.sp,
            color = Color.Black,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier
                .padding(16.dp)
        )
        LazyRow {
            items(financeList.size) { item ->
                FinanceItem(item)
            }
        }
    }
}

@Composable
fun FinanceItem(
    index: Int
) {
    val finance = financeList[index]
    var lastPaddingEnd = 0.dp
    if (index == financeList.size -1) {
        lastPaddingEnd = 16.dp
    }
    Box(
        modifier = Modifier
            .padding(start = 16.dp, end = lastPaddingEnd )
    )
    Column (
        modifier = Modifier
            .clip(shape = RoundedCornerShape(24.dp))
            .background(Color.Black)
            .size(120.dp)
            .clickable { }
            .padding(13.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(16.dp))
                .background(finance.backgroundColor)
                .padding(6.dp)
        ) {
            Icon(
                imageVector = finance.icon,
                contentDescription = finance.name,
                tint = Color.White
            )
        }
        Text(
            text = finance.name,
            color = Color.White,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 15.sp
        )
    }
}