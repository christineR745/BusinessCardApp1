package com.example.businesscard

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    //color = MaterialTheme.colorScheme.background
                ) {
                    BuildMyCard()
                }
            }
        }
    }
}

@Composable
fun DisplayCard(
    name: String,
    title: String,
    imageID: Int,
    imageDescription: String,
    phoneNumber: String,
    email: String,
    hours: String,
    modifier: Modifier = Modifier
) {
    val MyAppIcons = Icons.Outlined
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
            .background(Color(0xFF8ad5f0))
    ) {
        Column {
            Text(
                text = name,
                fontSize = 36.sp,
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
            )
            Text(
                text = title,
                fontSize = 24.sp,
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
            )
        }
        Image(
            painter = painterResource(id = imageID),
            contentDescription = imageDescription,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        Column(
            modifier = Modifier
                .padding(8.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(8.dp)
            ) {
                Icon(
                    MyAppIcons.Phone,
                    contentDescription = null
                )
                Text(
                    text = phoneNumber,
                    fontSize = 18.sp,
                    modifier = modifier
                )
            }
            Row(
                modifier = Modifier
                    .padding(8.dp)
            ) {
                Icon(
                    MyAppIcons.Email,
                    contentDescription = null
                )
                Text(
                    text = email,
                    fontSize = 18.sp,
                    modifier = modifier
                )
            }
            Row(
                modifier = Modifier
                    .padding(8.dp)
            ) {
                Icon(
                    MyAppIcons.DateRange,
                    contentDescription = null
                )
                Text(
                    text = hours,
                    fontSize = 18.sp,
                    modifier = modifier
                )
            }
        }
    }
}

@Composable
fun BuildMyCard() {
    DisplayCard(
        name = stringResource(id = R.string.my_name),
        title = stringResource(id = R.string.my_title),
        imageID = R.drawable.my_face,
        imageDescription = stringResource(id = R.string.my_image_description),
        phoneNumber = stringResource(id = R.string.my_phone_number),
        email = stringResource(id = R.string.my_email),
        hours = stringResource(id = R.string.my_availability)
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BuildMyCard()
    }
}