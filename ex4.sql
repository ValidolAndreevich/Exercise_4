PGDMP                     	    y            ex4    14.0    14.0     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16469    ex4    DATABASE     g   CREATE DATABASE ex4 WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_United States.1251';
    DROP DATABASE ex4;
                postgres    false            �            1259    16477    tree    TABLE     m   CREATE TABLE public.tree (
    id integer NOT NULL,
    parent_id integer,
    name character varying(20)
);
    DROP TABLE public.tree;
       public         heap    postgres    false            �          0    16477    tree 
   TABLE DATA           3   COPY public.tree (id, parent_id, name) FROM stdin;
    public          postgres    false    209   �       \           2606    16481    tree tree_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.tree
    ADD CONSTRAINT tree_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.tree DROP CONSTRAINT tree_pkey;
       public            postgres    false    209            �   ^   x�M��	�@E��{���oV0QAAD��1 ���d��x-�-��R!��m�5	��8*�gM٠�5�-�[��п4��Qr$EBƒH>Z�)�     