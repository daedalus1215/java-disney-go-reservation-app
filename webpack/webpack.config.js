// var webpack = require('webpack');
var path = require('path');
const MiniCssExtractPlugin = require("mini-css-extract-plugin");

module.exports = {

    mode: "development",
    devtool: "inline-source-map",
    entry: {
        index: './src/index.js',
        css: './src/css.js'
    },
    output: {
        path: path.resolve('../public', './dist'),
        filename: '[name].js'
    },
    resolve: {
        extensions: [".ts", ".js"]
    },
    module: {
        rules: [
            {test: /\.ts?$/, loader: "ts-loader"},
            {
                test: /\.css$/,
                use: [
                    {
                        loader: MiniCssExtractPlugin.loader,
                        options: {
                            publicPath: path.resolve('../public/dist', './main.css')
                        }
                    }
                ]
            },
            {
                test: /\.less$/,
                use: [{
                    loader: 'style-loader' // creates style nodes from JS strings
                }, {
                    loader: 'css-loader' // translates CSS into CommonJS
                }, {
                    loader: 'less-loader', // compiles Less to CSS
                    options: {
                        sourceMap: true
                    }
                }]
            },
            {test: /\.(gif|png|jpg|jpeg|svg|ttf|woff|eot)($|\?)/, loader: "file-loader"}
        ]
    }
};
