package com.example.composebasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composebasics.ui.theme.ComposeBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Article()
        }
    }
}

@Composable
fun Article() {
    ComposeBasicsTheme {
        Column(modifier = Modifier.fillMaxSize()) {
            val painter = painterResource(R.drawable.bg_compose_background)
            Image(
                painter = painter, contentDescription = "header", contentScale = ContentScale.Fit
            )
            Text(
                text = stringResource(R.string.screen_title),
                modifier = Modifier.padding(16.dp),
                fontSize = 24.sp
            )
            Text(
                text = stringResource(R.string.screen_description),
                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                textAlign = TextAlign.Justify
            )
            Text(
                text = stringResource(R.string.screen_details),
                modifier = Modifier.padding(16.dp),
                textAlign = TextAlign.Justify
            )
        }
    }
}

@Composable
fun TaskManager() {
    ComposeBasicsTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(R.drawable.ic_task_completed),
                contentDescription = stringResource(
                    R.string.task_completed_icon
                ),
            )
            Text(
                text = stringResource(R.string.task_manager_primary_text),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
            )
            Text(text = stringResource(R.string.task_manager_secondary_text), fontSize = 16.sp)
        }
    }
}

@Composable
fun QuadrantItem(
    title: String, description: String, modifier: Modifier, background: Color
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(background)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 16.dp), text = title
        )
        Text(text = description)
    }
}

@Composable
fun QuadrantScreen() {
    ComposeBasicsTheme {
        Column(modifier = Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
            ) {
                QuadrantItem(
                    title = "Text composable",
                    description = "Displays text and follows the recommended Material Design guidelines.",
                    background = Color(0xFFEADDFF),
                    modifier = Modifier.weight(1f)
                )
                QuadrantItem(
                    title = "Image composable",
                    description = "Creates a composable that lays out and draws a given Painter class object.",
                    background = Color(0xFFD0BCFF),
                    modifier = Modifier.weight(1f)
                )

            }
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
            ) {
                QuadrantItem(
                    title = "Row composable",
                    description = "A layout composable that places its children in a horizontal sequence.",
                    background = Color(0xFFB69DF8),
                    modifier = Modifier.weight(1f)
                )
                QuadrantItem(
                    title = "Column composable",
                    description = "A layout composable that places its children in a vertical sequence.",
                    background = Color(0xFFF6EDFF),
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    QuadrantScreen()
}