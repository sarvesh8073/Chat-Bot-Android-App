# Chatbot Application

This is a chatbot application built using the Gemini API. The application leverages natural language processing to provide responses to user queries.

## Table of Contents
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Configuration](#configuration)
- [Usage](#usage)
- [Contributing](#contributing)


## Prerequisites

Before you begin, ensure you have met the following requirements:
- You have installed [Android Studio](https://developer.android.com/studio).
- You have an API key from the [Google Gemini Developers website](https://developers.google.com/gemini).

## Installation

To install this project, follow these steps:

1. Clone the repository:
    ```sh
    git clone https://github.com/sarvesh8073/Chat-Bot-Android-App.git
    ```
2. Open the project in Android Studio.

## Configuration

Before running the application, you need to configure your API key:

1. Open the `constants.kt`.
2. Find the following placeholder:
    ```kotlin
    const val apikey = "YOUR_API_KEY_HERE"
    ```
3. Replace `"YOUR_API_KEY_HERE"` with your actual Gemini API key.

You can obtain your API key from the [Google Gemini Developers website](https://developers.google.com/gemini).

## Usage

To use the chatbot application:

1. Ensure you have configured your API key as described in the [Configuration](#configuration) section.
2. Build and run the application in Android Studio.
3. Interact with the chatbot through the provided interface.

## Contributing

Contributions are always welcome! To contribute:

1. Fork the repository.
2. Create a new branch:
    ```sh
    git checkout -b feature/your-feature-name
    ```
3. Make your changes and commit them:
    ```sh
    git commit -m 'Add some feature'
    ```
4. Push to the branch:
    ```sh
    git push origin feature/your-feature-name
    ```
5. Open a pull request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

