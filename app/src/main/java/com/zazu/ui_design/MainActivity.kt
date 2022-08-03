package com.zazu.ui_design

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zazu.ui_design.R.drawable.bg_main
import com.zazu.ui_design.R.drawable.ic_orange
import com.zazu.ui_design.ui.theme.UI_DesignTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            mainTheme {
              HomeScreen()
            }
        }//        Card(){

    }
}

@Composable
fun mainTheme(content: @Composable () -> Unit) {
    UI_DesignTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            content()
        }
    }
}

@Composable
fun HomeScreen() {
    Box(modifier = Modifier.verticalScroll(rememberScrollState())) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .offset(0.dp, (-30).dp),
            painter = painterResource(id = bg_main),
            contentDescription = "background",
            contentScale = ContentScale.FillWidth
        )
        Column {
            AppBar()
            Content()
            Header()
            viewPromotions()
        }
    }
}

@Composable
fun AppBar() {
    var value by remember { mutableStateOf(TextFieldValue("")) }
    Row(
        Modifier
            .padding(8.dp)
            .height(48.dp).fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Outlined.Menu, contentDescription = "", tint = Color.White)

        }
        BasicTextField(value = value, onValueChange = { value = it },
            decorationBox = { innerTextField ->
                Row(
                    modifier = Modifier
                        .background(Color.White, RoundedCornerShape(percent = 15))
                        .padding(10.dp)
                ) {
                    Icon(imageVector = Icons.Outlined.Search, contentDescription = "")
                    if (value.text.isEmpty()) {
                        Text(text = "Search For Items....")
                    }
                    innerTextField()
                }
            })
        Spacer(modifier = Modifier.width(8.dp))
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Outlined.FavoriteBorder,
                contentDescription = "",
                tint = Color.White
            )

        }
    }
}

@Composable
fun Content() {
    Column {
        Surface(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(8.dp),
            color = Color.White,
            tonalElevation = 8.dp
        ) {
            Greeting(name = "steve")
        }

    }
}

@Composable
fun Header() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(9.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Category")
        TextButton(onClick = { /*TODO*/ }) {
            Text(
                text = "Sell all",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.primary
            )

        }
    }
}

@Composable
fun viewPromotions() {
    LazyRow(
        Modifier
            .height(160.dp)
            .padding(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp), content = {
            item {
                promotions(
                    title = "Vegs",
                    subTitle = "Ksh.200",
                    header = "Fruits",
                    backgroundColor = Color.Red,
                    imagePainter = painterResource(
                        id = ic_orange
                    )
                )
            }
            item {
                promotions(
                    title = "Vegs",
                    subTitle = "Ksh.200",
                    header = "Fruits",
                    backgroundColor = Color.Blue,
                    imagePainter = painterResource(
                        id = ic_orange
                    )
                )
            }
        })
}

@Composable
fun promotions(
    title: String,
    subTitle: String,
    header: String,
    backgroundColor: Color,
    imagePainter: Painter
) {
    Surface(Modifier.width(250.dp), shape = RoundedCornerShape(8.dp), color = backgroundColor) {
        Row {
            Column(
                Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxHeight(), verticalArrangement = Arrangement.Center
            ) {
                Text(text = title, fontSize = 14.sp, color = Color.White)
                Text(text = subTitle, fontSize = 16.sp, color = Color.White)
                Text(text = header, fontSize = 28.sp, color = Color.White)
            }
            Image(
                painter = imagePainter, contentDescription = "",
                Modifier
                    .fillMaxHeight()
                    .weight(1f), alignment = Alignment.CenterEnd, contentScale = ContentScale.Crop
            )
        }
    }


}


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    UI_DesignTheme {
        HomeScreen()
    }
}