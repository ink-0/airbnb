import React from 'react';
import styled from 'styled-components';
import PeopleCard from './PeopleCard';

const PeopleModal = () => {
  return (
    <PeopleModalDiv>
      <PeopleCard type="adult" />
      <LineDivider />
      <PeopleCard type="child" />
      <LineDivider />
      <PeopleCard type="baby" />
    </PeopleModalDiv>
  );
};

const PeopleModalDiv = styled.div`
  position: absolute;
  top: 6rem;
  left: 27rem;
  width: 31rem;
  height: 23rem;
  border-radius: 40px;
  padding: 4rem;
  background-color: ${({ theme }) => theme.colors.white};
  box-shadow: 0px 4px 10px rgba(51, 51, 51, 0.1),
    0px 0px 4px rgba(51, 51, 51, 0.05);
`;

const LineDivider = styled.div`
  width: 100%;
  border-bottom: 1px solid #c4c4c4;
  margin: 1.4em 0;
`;

export default PeopleModal;
