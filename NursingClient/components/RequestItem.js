import React, { useState } from "react";
import { StyleSheet, Text, View, TouchableOpacity } from "react-native";

export default function RequestItem({ item }) {
  const [status, setStatus] = useState(false);

  return (
    <View>
      <View style={styles.item}>
        <View style={styles.left}>
          <Text style={styles.text}>{item.name}</Text>
          <Text style={styles.bodyText}>{item.desc}</Text>
          <Text style={styles.bodyText}>{item.staff}</Text>
          <Text style={styles.bodyText}>{item.time}</Text>
        </View>
        <View style={styles.right}>
          <TouchableOpacity
            style={status ? styles.button : styles.clickedButton}
            onPress={() => {
              setStatus(!status);
            }}
          >
            <Text style={styles.buttonText}>{status ? "Seen" : ""}</Text>
          </TouchableOpacity>
        </View>
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  item: {
    flex: 1,
    flexDirection: "row",
    height: 130,
    borderRadius: 5,
    padding: 10,
    marginTop: 5,
    borderColor: "#bbb",
    backgroundColor: "#f1faee",
    borderWidth: 1,
    borderStyle: "solid",
  },
  bodyText: {
    fontSize: 20,
  },
  text: {
    fontWeight: "bold",
    color: "#1d3557",
    fontSize: 30,
  },
  left: {
    width: 270,
  },
  right: {},
  button: {
    alignSelf: "flex-end",
    justifyContent: "center",
    width: 100,
    height: 100,
    backgroundColor: "#ffbe0b",
    borderRadius: 10,
  },
  clickedButton: {
    alignSelf: "flex-end",
    justifyContent: "center",
    width: 100,
    height: 100,
    backgroundColor: "#e63946",
    borderRadius: 10,
  },
  buttonText: {
    fontWeight: "bold",
    color: "#f1faee",
    alignSelf: "center",
    fontSize: 30,
    fontFamily: "Avenir",
  },
});
