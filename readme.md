# Gardening Journal App

The Gardening Journal App is an Android application that serves as a digital companion for gardening enthusiasts. It allows users to keep track of their plants, log gardening activities, and access detailed information about each plant.

## Features

- **Garden Log:** View a comprehensive list of all plants in your garden.
- **Plant Details:** Access detailed information about each plant, including name, type, watering frequency, and planting date.
- **Add New Plants:** Easily add new plants to your gardening journal with customizable details.

## Technologies Used

- **Android Kotlin:** The app is developed using the Kotlin programming language for Android.
- **Architecture Components (ViewModel, LiveData):** Utilizes Android's Architecture Components for efficient data management and UI updates.
- **Navigation Component:** Implements a clear and structured navigation flow using the Navigation component and NavHostFragment.
- **Room Database:** Stores and retrieves plant data with the Room database, providing a robust and persistent storage solution.
- **Coroutines:** Implements coroutines for managing asynchronous operations, ensuring smooth execution without blocking the main thread.

## Building and Running the App

### Prerequisites

- [Android Studio](https://developer.android.com/studio) installed
- [Git](https://git-scm.com/) installed

### Getting Started

1. **Clone the Repository:**

    ```bash
    git clone https://github.com/romankhadka/gardening-journal-app.git
    cd gardening-journal-app
    ```

2. **Open in Android Studio:**

    Open the project in Android Studio.

3. **Build and Run:**

    Build and run the app on an Android emulator or a physical device.

## Implementation Details

- **ViewModel and LiveData:** Leverages Android's ViewModel and LiveData to handle UI-related data and observe changes.
- **Navigation Structure:** Utilizes the Navigation component for a well-defined and navigable structure within the app.
- **Room Database:** Implements a Room database with a Data Access Object (DAO) to perform efficient database operations.
- **Coroutines for Concurrency:** Uses coroutines for asynchronous operations, ensuring responsiveness without blocking the main thread.

## Additional Notes

- The app includes a sample data feature to help users quickly populate their gardening journal.
- Contributions are welcome! If you have ideas for improvement or bug fixes, feel free to submit a pull request.

Explore the codebase and happy gardening!

