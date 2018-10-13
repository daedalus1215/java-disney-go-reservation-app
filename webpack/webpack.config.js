// var webpack = require('webpack');
var path = require('path');
const MiniCssExtractPlugin = require("mini-css-extract-plugin");
const HtmlWebpackPlugin = require("html-webpack-plugin");

module.exports = {

    mode: "development",
    devtool: "inline-source-map",
    entry: {
        // index: './src/index.js',
        // indexPage: './src/typescript/pages/index/IndexPage.ts',
        indexPage: './src/Pages/Index/IndexPage.js',
        css: './src/css.js'
    },
    output: {
        path: path.resolve('../public', './dist'),
        filename: '[name].js'
    },
    resolve: {
        extensions: ['.ts', '.tsx', '.js', '.less', '.jpg'],
        alias: {
            "kendo-ui": path.resolve(__dirname, './node_modules/@progress/kendo-ui/js/kendo.all.js')
        }
    },
    module: {
        rules: [
            {
                test: /\.css$/,
                use: [MiniCssExtractPlugin.loader,'css-loader']
            },
            {
                test: /\.less$/,
                use: [
                    MiniCssExtractPlugin.loader,
                    { loader: 'css-loader', options: { url: false, sourceMap: true } },
                    { loader: 'less-loader', options: { sourceMap: true } }
                ]
            },
            {
                test: /\.js$/,
                exclude: /(node_modules)/,
                use: {
                    loader: 'babel-loader'
                }
            },
            {test: /\.(gif|png|jpg|jpeg|svg|ttf|woff|eot)($|\?)/, loader: "file-loader"}
        ]
    },
    watchOptions: {
        aggregateTimeout: 300,
        poll: 1000,
        ignored: /node_modules/
    },
    plugins: [
        new MiniCssExtractPlugin({
            path: "../public/dist",
            filename: "style.css"
        })
    ]
};
