package com.leoevg.gini.ui.components


import android.R.attr.onClick
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.leoevg.gini.ui.theme.GiniTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leoevg.gini.R
import com.leoevg.gini.data.model.CardAssembly
import androidx.compose.material3.Button

@Composable
fun PixabayItem(
    cardData: CardAssembly = CardAssembly(),
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_default),
            contentDescription = "background",
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = modifier
                .fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .padding(16.dp)
            ) {
                // Likes
                Button(
                    onClick = { },
                    modifier = Modifier
                        .fillMaxHeight(0.1f)
                        .fillMaxWidth(fraction = 0.2f)
                ) {
                    Text(
                        text = cardData.likes.toString(),
                        modifier = Modifier.padding(2.dp),
                        fontSize = 25.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
                // Comments
                Button(
                    onClick = { },
                    modifier = Modifier
                        .fillMaxHeight(0.1f)
                        .fillMaxWidth(fraction = 0.2f)
                ) {
                    Text(
                        text = cardData.comments.toString(),
                        modifier = Modifier.padding(2.dp),
                        fontSize = 25.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }


                }
            }
        }
    }


@Composable
@Preview(showBackground = true)
fun PixabayItemPreview(){
    GiniTheme (
        darkTheme = false
    ){
        PixabayItem()
    }
}