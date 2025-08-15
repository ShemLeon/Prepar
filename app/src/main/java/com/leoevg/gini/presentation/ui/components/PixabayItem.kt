package com.leoevg.gini.presentation.ui.components


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.leoevg.gini.presentation.ui.theme.GiniTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leoevg.gini.R
import androidx.compose.ui.graphics.Color
import coil.compose.AsyncImage
import com.leoevg.gini.data.network.model.HitResponse

@Composable
fun PixabayItem(
    modifier: Modifier = Modifier,
    cardData: HitResponse = HitResponse()
) {
    val size = 15
    Box(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(16f / 10f)
    ) {
        AsyncImage(
            model = cardData.image,
            contentDescription = "background",
            contentScale = ContentScale.Crop,
            placeholder = painterResource(id = R.drawable.img_default),
            error = painterResource(id = R.drawable.img_default),
            modifier = Modifier.fillMaxSize()
        )
        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .padding(10.dp)
        ) {
            // Likes
            Button(
                modifier = Modifier
                    .padding(8.dp)
                    .height(30.dp),
                onClick = { },
                contentPadding = PaddingValues(horizontal = 8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Gray
                )
            ) {
                Text(
                    text = "Likes: ${cardData.likes}",
                    modifier = Modifier
                        .padding(start = 2.dp, end = 2.dp),
                    fontSize = size.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
            }
            Button(
                modifier = Modifier
                    .padding(8.dp)
                    .height(30.dp),
                onClick = { },
                contentPadding = PaddingValues(horizontal = 8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Gray
                )
            ) {
                Text(
                    text = "Comments: ${cardData.comments}",
                    modifier = Modifier.padding(start = 2.dp, end = 2.dp),
                    fontSize = size.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
            }
        }
    }


@Composable
@Preview(showBackground = false)
fun PixabayItemPreview(){
    val fakeItem = HitResponse(
        image = "img_default",
        likes = 100,
        comments = 100
    )
    GiniTheme {
        PixabayItem(cardData = fakeItem)
    }
}

// a197e51143454561a9f6e478473e995a