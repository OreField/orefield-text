/*
 * Copyright (c) 2022 OreField
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

// @ts-check
// Note: type annotations allow type checking and IDEs autocompletion

const lightCodeTheme = require("prism-react-renderer/themes/github");
const darkCodeTheme = require("prism-react-renderer/themes/dracula");

/** @type {import('@docusaurus/types').Config} */
const config = {
    title: "OreField Text",
    tagline: "Beautiful   messages",
    url: "https://orefield.github.io/",
    baseUrl: "/orefield-text/",
    onBrokenLinks: "throw",
    onBrokenMarkdownLinks: "warn",
    favicon: "img/favicon.ico",

    // GitHub pages deployment config.
    // If you aren't using GitHub pages, you don't need these.
    organizationName: "orefield", // Usually your GitHub org/user name.
    projectName: "orefield-text", // Usually your repo name.

    // Even if you don't use internalization, you can use this field to set useful
    // metadata like html lang. For example, if your site is Chinese, you may want
    // to replace "en" with "zh-Hans".
    i18n: {
        defaultLocale: "en",
        locales: ["en"],
    },

    presets: [
        [
            "classic",
            /** @type {import('@docusaurus/preset-classic').Options} */
            {
                docs: {
                    sidebarPath: require.resolve("./sidebars.js"),
                    // Please change this to your repo.
                    // Remove this to remove the "edit this page" links.
                    editUrl:
                        "https://github.com/facebook/docusaurus/tree/main/packages/create-docusaurus/templates/shared/",
                },
                theme: {
                    customCss: require.resolve("./src/css/custom.css"),
                },
            },
        ],
    ],

    themeConfig:
        /** @type {import('@docusaurus/preset-classic').ThemeConfig} */
        {
            navbar: {
                title: "OreField Text",
                logo: {
                    alt: "OreField Logo",
                    src: "img/orefield.png",
                },
                items: [
                    {
                        type: "doc",
                        docId: "getting-started",
                        position: "left",
                        label: "Getting Started",
                    },
                    {
                        href: "https://github.com/orefield/orefield-text",
                        label: "GitHub",
                        position: "right",
                    },
                ],
            },
            footer: {
                style: "dark",
                links: [
                    {
                        title: "Docs",
                        items: [
                            {
                                label: "Getting started",
                                to: "/docs/getting-started",
                            },
                        ],
                    },
                    {
                        title: "Community",
                        items: [
                            {
                                label: "Discord",
                                href: "https://discordapp.com/invite/orefield",
                            },
                        ],
                    },
                    {
                        title: "More",
                        items: [
                            {
                                label: "GitHub",
                                href: "https://github.com/orefield/orefield-text",
                            },
                        ],
                    },
                ],
                copyright: `Copyright © ${new Date().getFullYear()} OreField`,
            },
            prism: {
                theme: lightCodeTheme,
                darkTheme: darkCodeTheme,
            },
        },
};

module.exports = config;
