import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  int _selectedIndex = 0;

  // List of widgets to display for each tab
  static final List<Widget> _widgetOptions = <Widget>[
    // Display the bike image on the Home screen with scrollable content
    SingleChildScrollView(
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          const Text('Home Screen', style: TextStyle(fontSize: 24)),
          Image.asset('assets/bike.png'), // Display the bike image
        ],
      ),
    ),
    const Text('Search Screen', style: TextStyle(fontSize: 24)),
    const Text('Profile Screen', style: TextStyle(fontSize: 24)),
  ];

  void _onItemTapped(int index) {
    setState(() {
      _selectedIndex = index; // Set the selected index
    });
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Bike Race Game',
      debugShowCheckedModeBanner: false, // Hide debug banner
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Bike Race Game'),
        ),
        body: Center(
          child: _widgetOptions.elementAt(_selectedIndex), // Show selected screen
        ),
        bottomNavigationBar: BottomNavigationBar(
          items: const <BottomNavigationBarItem>[
            BottomNavigationBarItem(
              icon: Icon(Icons.home),
              label: 'Home',
            ),
            BottomNavigationBarItem(
              icon: Icon(Icons.search),
              label: 'Search',
            ),
            BottomNavigationBarItem(
              icon: Icon(Icons.person),
              label: 'Profile',
            ),
          ],
          currentIndex: _selectedIndex, // Highlight the selected item
          selectedItemColor: Colors.blue,
          onTap: _onItemTapped, // Handle tap events
        ),
      ),
    );
  }
}
