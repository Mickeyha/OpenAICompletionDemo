# OpenAICompletionDemo

一個 Android Demo App，示範如何透過 Retrofit 串接 OpenAI Chat Completions API，使用 Jetpack Compose 建構 UI，並採用 Repository + ViewModel 架構。

## 功能

- 輸入文字，送出至 OpenAI Chat Completions API（`gpt` 模型）
- 顯示 AI 回覆結果
- 完整的 Repository Pattern + ViewModel 架構示範

## 技術架構

| 項目 | 說明 |
|------|------|
| 語言 | Kotlin |
| UI | Jetpack Compose + Material3 |
| 最低 SDK | Android 13 (API 33) |
| 網路 | Retrofit2 + OkHttp3 |
| 資料解析 | Gson |
| 架構 | Repository Pattern + ViewModel |

## 專案結構

```
app/src/main/java/com/mickey/openaicompletiondemo/
├── data/
│   ├── AppContainer.kt        # DI 容器，設定 Retrofit 與 API Key
│   └── OpenAIRepository.kt    # Repository 介面與實作
├── model/
│   ├── CompletionRequest.kt   # API 請求 Model
│   ├── CompletionResponse.kt  # API 回應 Model
│   ├── CompletionChoices.kt
│   └── CompletionMessage.kt
├── network/
│   └── OpenAIApiService.kt    # Retrofit API 介面
├── ui/
│   ├── OpenAICompletionApp.kt
│   ├── screens/
│   │   ├── HomeScreen.kt      # 主畫面 UI
│   │   └── CompletionViewModel.kt
│   └── theme/
├── MainActivity.kt
└── OpenAICompletionApplication.kt
```

## 使用方式

1. 前往 [OpenAI Platform](https://platform.openai.com/api-keys) 取得 API Key
2. 開啟 `app/src/main/java/com/mickey/openaicompletiondemo/data/AppContainer.kt`
3. 將 `API_KEY` 替換成你的 API Key
4. 將 `OpenAI-Organization` header 替換成你的 Organization ID（可選）
5. 執行 App

> **注意**：請勿將真實的 API Key 或 Organization ID commit 至版本控制。建議改用 `local.properties` 儲存敏感資訊。
