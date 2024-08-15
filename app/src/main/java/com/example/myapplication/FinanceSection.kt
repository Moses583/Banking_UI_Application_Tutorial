package com.example.myapplication

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
import androidx.compose.material.icons.rounded.DataExploration
import androidx.compose.material.icons.rounded.MonetizationOn
import androidx.compose.material.icons.rounded.StarHalf
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.models.Finance
import com.example.myapplication.ui.theme.BlueStart
import com.example.myapplication.ui.theme.GreenStart
import com.example.myapplication.ui.theme.OrangeStart
import com.example.myapplication.ui.theme.PurpleStart

val finances = listOf(
    Finance(
        icon = Icons.Rounded.StarHalf,
        name = "Business",
        background = OrangeStart
    ),
    Finance(
        icon = Icons.Rounded.Wallet,
        name = "Wallet",
        background = BlueStart
    ),
    Finance(
        icon = Icons.Rounded.DataExploration,
        name = "Analytics",
        background = PurpleStart
    ),
    Finance(
        icon = Icons.Rounded.MonetizationOn,
        name = "Finances",
        background = GreenStart
    )
)

@Preview(showBackground = true)
@Composable
fun FinanceSection() {
    Column {
        Text(
            text = "Finances",
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground,
            fontSize = 22.sp,
            modifier = Modifier.padding(16.dp))
        LazyRow {
            items(finances.size){ index ->
                FinanceItem(index)
            }
        }
    }
}


@Composable
fun FinanceItem(index: Int) {
    val finance = finances[index]

    var lastItemPaddingEnd = 0.dp
    if (index == finances.size - 1){
        lastItemPaddingEnd = 16.dp
    }
    Box(modifier = Modifier.padding(start = 16.dp, end = lastItemPaddingEnd)){
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(MaterialTheme.colorScheme.secondaryContainer)
                .size(120.dp)
                .clickable {}
                .padding(13.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Box(modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(finance.background)
                .padding(6.dp)
            ){
                Icon(
                    imageVector = finance.icon,
                    contentDescription = finance.name,
                    tint = Color.White
                )
            }

            Text(
                text = finance.name,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                fontWeight = FontWeight.SemiBold,
                fontSize = 15.sp)
        }
    }
}
