package com.csm.gardenapp.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.csm.gardenapp.R
import com.csm.gardenapp.presentation.component.FaqItem
import com.csm.gardenapp.presentation.component.ScreenTitle
import com.csm.gardenapp.presentation.viewModel.FaqScreenViewModel

@Composable
fun FaqScreen(
    viewModel: FaqScreenViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth()
            ) {
                ScreenTitle(
                    modifier = Modifier.padding(start = 20.dp),
                    title = stringResource(id = R.string.faq)
                )
            }

            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(viewModel.faqs) {faq ->
                    FaqItem(
                        faq = faq,
                        modifier = Modifier.padding(top = 15.dp)
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun FaqScreenPreview() {
    FaqScreen()
}