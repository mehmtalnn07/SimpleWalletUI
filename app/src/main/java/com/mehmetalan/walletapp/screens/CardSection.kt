package com.mehmetalan.walletapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mehmetalan.walletapp.R
import com.mehmetalan.walletapp.data.Card

val cards = listOf(
    Card(
        cardType = "VISA",
        cardNumber = "1234 5678 9012 3456",
        cardName = "Business",
        balance = 74.765,
        color = Color.Black
    ),
    Card(
        cardType = "MASTER CARD",
        cardNumber = "0987 6543 2109 8765",
        cardName = "Investment",
        balance = 12.245,
        color = Color.Black
    ),
    Card(
        cardType = "VISA",
        cardNumber = "1029 3847 5610 2938",
        cardName = "Credit Card",
        balance = 5.413,
        color = Color.Black
    ),
    Card(
        cardType = "MASTER CARD",
        cardNumber = "0192 8273 7465 0296",
        cardName = "Bank Card",
        balance = 55.555,
        color = Color.Black
    ),
)

@Preview
@Composable
fun CardSection() {
    LazyRow {
        items(cards.size) { index ->
            CardItem(index)
        }
    }
}

@Composable
fun CardItem(
    index: Int
) {
    val card = cards[index]
    var lastItemPaddingEnd = 0.dp
    if (index == cards.size -1) {
        lastItemPaddingEnd = 16.dp
    }
    var image = painterResource(id = R.drawable.visa)
    if(card.cardType == "MASTER CARD") { 
        image = painterResource(id = R.drawable.mastercard)
    }
    Box(
        modifier = Modifier
            .padding(start = 16.dp, end = lastItemPaddingEnd)
    ) {
        Column (
            modifier = Modifier
                .clip(shape = RoundedCornerShape(24.dp))
                .background(card.color)
                .width(250.dp)
                .height(160.dp)
                .clickable { }
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = image,
                contentDescription = card.cardName,
                modifier = Modifier
                    .width(60.dp)
                    .size(60.dp)
            )
            Spacer(
                modifier = Modifier
                    .size(10.dp)
            )
            Text(
                text = card.cardName,
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.ExtraBold
            )
            Text(
                text = card.balance.toString(),
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.ExtraBold
            )
            Text(
                text = card.cardNumber,
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.ExtraBold
            )
        }
    }
}