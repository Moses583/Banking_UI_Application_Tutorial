package com.example.myapplication

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AttachMoney
import androidx.compose.material.icons.rounded.CurrencyFranc
import androidx.compose.material.icons.rounded.CurrencyPound
import androidx.compose.material.icons.rounded.CurrencyRupee
import androidx.compose.material.icons.rounded.CurrencyYen
import androidx.compose.material.icons.rounded.EuroSymbol
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.models.Currency

val currencies = listOf(
    Currency(
        name = "USD",
        buy = 100.34f,
        sell= 102.45f,
        icon = Icons.Rounded.AttachMoney
    ),
    Currency(
        name = "EUR",
        buy = 130.34f,
        sell= 132.45f,
        icon = Icons.Rounded.EuroSymbol
    ),
    Currency(
        name = "GBP",
        buy = 160.34f,
        sell= 162.45f,
        icon = Icons.Rounded.CurrencyPound
    ),
    Currency(
        name = "YEN",
        buy = 78.34f,
        sell= 81.45f,
        icon = Icons.Rounded.CurrencyYen
    ),
    Currency(
        name = "FRA",
        buy = 99.34f,
        sell= 89.45f,
        icon = Icons.Rounded.CurrencyFranc
    ),
    Currency(
        name = "RUP",
        buy = 45.34f,
        sell= 43.45f,
        icon = Icons.Rounded.CurrencyRupee
    )
)

@Preview(showBackground = true)
@Composable
fun CurrenciesSection(modifier: Modifier = Modifier) {
    var isVisible by remember {
       mutableStateOf(false)
    }
    var iconState by remember {
        mutableStateOf(Icons.Rounded.KeyboardArrowUp)
    }
    Column (
        modifier = Modifier
            .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
            .background(MaterialTheme.colorScheme.inverseOnSurface)
            .animateContentSize()
    ){
        Row (
            modifier = Modifier
                .padding(16.dp)
                .animateContentSize()
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Box(modifier = Modifier
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.secondary)
                .clickable {
                    isVisible = !isVisible
                    iconState = if (isVisible) {
                        Icons.Rounded.KeyboardArrowUp
                    } else {
                        Icons.Rounded.KeyboardArrowDown
                    }
                }){
                Icon(
                    imageVector = iconState,
                    contentDescription = "Currency Icon",
                    tint = MaterialTheme.colorScheme.onSecondary,
                    modifier = Modifier.size(25.dp))
            }
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                text = "Currencies"
            )

        }
        HorizontalDivider(
            thickness = 2.dp,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .background(color = Color.Black)
        )

        if (isVisible){
            BoxWithConstraints(
                modifier = Modifier
                    .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
                    .background(MaterialTheme.colorScheme.background)
                    .padding(horizontal = 16.dp)
                    .fillMaxSize()
            ){
                val boxWithConstraintsScope = this
                val width = boxWithConstraintsScope.maxWidth / 3
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = "Currency",
                            modifier = Modifier.width(width),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                        Text(
                            text = "Buy",
                            modifier = Modifier.width(width),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.onBackground,
                            textAlign = TextAlign.End
                        )
                        Text(
                            text = "Sell",
                            modifier = Modifier.width(width),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.onBackground,
                            textAlign = TextAlign.End
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    LazyColumn {
                        items(currencies.size){ index ->
                            CurrencyItem(index,width)
                        }
                    }
                }
            }
        }

    }
}

@Composable
fun CurrencyItem(index: Int,width: Dp) {

}
