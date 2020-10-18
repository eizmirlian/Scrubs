import React, {useState} from 'react';
import {
  StyleSheet,
  ActivityIndicator,
  Text,
  View,
  FlatList,
  TextInput,
  Button,
} from 'react-native';
import Header from './components/header';
import RequestItem from './components/RequestItem';
import {Swipeable} from 'react-native-gesture-handler';
import nodejs from 'nodejs-mobile-react-native';

export default class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {isLoading: true};
  }

  deleteItemById = (key) => {
    const filteredData = this.state.dataSource.filter(
      (item) => item.key !== key,
    );
    this.setState({dataSource: filteredData});
  };

  componentDidMount() {
    nodejs.channel.addListener(
      'message',
      (msg) => {
        alert('From node: ' + msg);
      },
      this,
    );
    return fetch(
      'https://raw.githubusercontent.com/MattLiCodes/NursingApp/main/data2.json',
    )
      .then((response) => response.json())
      .then((responseJson) => {
        this.setState(
          {
            isLoading: false,
            dataSource: responseJson.requests,
          },
          function () {},
        );
      })
      .catch((error) => {
        console.error(error);
      });
  }

  render() {
    if (this.state.isLoading) {
      return (
        <View style={{flex: 1, padding: 20}}>
          <ActivityIndicator />
        </View>
      );
    }
    const RightAction = () => (
      <View style={styles.rightAction}>
        <Text style={styles.textAction}>Completed!</Text>
      </View>
    );
    return (
      <View style={styles.container}>
        <Header />
        <View style={styles.content}>
          <FlatList
            data={this.state.dataSource}
            renderItem={({item}) => (
              <Swipeable
                renderRightActions={RightAction}
                onSwipeableRightOpen={() => this.deleteItemById(item.key)}>
                <RequestItem item={item} />
              </Swipeable>
            )}
            keyExtractor={({key}, index) => key}
          />
        </View>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#1d3557',
  },
  content: {
    paddingTop: 0,
    paddingHorizontal: 10,
    marginTop: 0,
    borderRadius: 10,
  },
  textAction: {
    fontFamily: 'Avenir',
    fontWeight: 'bold',
    fontSize: 40,
    color: '#f1faee',
    alignSelf: 'center',
  },
  rightAction: {
    backgroundColor: '#02c39a',
    justifyContent: 'center',
    width: 100,
    flex: 1,
    flexDirection: 'row',
    height: 120,
    borderRadius: 5,
    marginTop: 5,
    padding: 10,
  },
});

// color scheme:
// red #e63946,
// white #f1faee,
// baby blue #a8dadc,
// cerulean #457b9d,
// navy #1d3557

// fbed2720-176f-495d-b481-0725ef9a4fa3
